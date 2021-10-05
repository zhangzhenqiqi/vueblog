
import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'

import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'

import axios from 'axios'
import './axios.js'

// import mavonEditor from 'mavon-editor'
// import 'mavon-editor/dist/css/index.css'

import VMdPreview from '@kangc/v-md-editor/lib/preview';
import VueMarkdownEditor from '@kangc/v-md-editor';
import '@kangc/v-md-editor/lib/style/base-editor.css';
import githubTheme from '@kangc/v-md-editor/lib/theme/github.js';
import '@kangc/v-md-editor/lib/theme/style/github.css';



//代码高亮插件
import hljs from 'highlight.js/lib/core'
import java from 'highlight.js/lib/languages/java'
hljs.registerLanguage('java', java);



VMdPreview.use(githubTheme, {
    Hljs: hljs,
})
VueMarkdownEditor.use(githubTheme, {
    Hljs: hljs
});
const app = createApp(App);
app.config.globalProperties.$axios = axios
app.use(ElementPlus).use(store).use(router).use(VueMarkdownEditor).use(VMdPreview).mount('#app')
