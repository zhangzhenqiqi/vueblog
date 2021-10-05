<template>
    <div>
        <Header></Header>
        <div class="mblog">
            <h2>{{blog.title}}</h2>
            <el-link icon="el-icon-edit" v-if="ownBlog">
                <router-link :to="{name:'BlogEdit',params:{blogId:blog.id}}">编辑</router-link>
            </el-link>
            <el-divider></el-divider>
            <v-md-preview :text="blog.content"></v-md-preview>
        </div>
    </div>
</template>

<script>
    import 'github-markdown-css';
    import Header from '../components/Header';
    export default {
        name: "BlogDetail",
        components: { Header },
        data() {
            return {
                blog: {
                    id: '',
                    title: '',
                    cotent: ''
                },
                ownBlog: false
            }
        },
        created() {
            const blogId = this.$route.params.blogId;
            const _this = this;
            console.log('this is BlogDetail: ', this)
            this.$axios.get('/blog/' + blogId).then(res => {
                const blog = res.data.data;
                _this.blog.id = blog.id;
                _this.blog.title = blog.title;
                _this.blog.content = blog.content
                _this.ownBlog = (blog.userId === _this.$store.getters.getUser.id);
            })
        },
    }
</script>
<style scoped>
    .mblog {
        box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
        width: 100%;
        min-height: 700px;
        padding: 20px 15px;
    }
</style>