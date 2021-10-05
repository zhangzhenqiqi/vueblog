import axios from "axios";
import { ElementPlus, ElMessage } from 'element-plus'

import router from './router'
import store from './store'

axios.defaults.baseURL = "http://localhost:8081"

//前置拦截
axios.interceptors.request.use(config => {
    // Do something before request is sent
    return config;
}, error => {
    // Do something with request error
    return Promise.reject(error);
});


axios.interceptors.response.use(response => {
    // Do something before response is sent
    let res = response.data;
    // console.log("====================");
    // console.log(res);
    // console.log("====================");
    if (res.code === 200) {
        return response;
    } else {
        ElMessage.error('出错了哦', { duration: 3 * 1000 });
        // ElementPlus.Message.error('错了哦，这是一条错误信息', { duration: 3 * 1000 });
        return Promise.reject(response.data.msg);
    }
}, error => {
    console.log(error)
    if (error.response.data) {
        error.message = error.response.data.msg
    }

    if (error.response.status === 401) {
        store.commit("REMOVE_INFO")
        router.push("/login")
    }
    ElMessage.error(error.message, { duration: 3 * 1000 });
    // ElementPlus.Message.error(error.message, { duration: 3 * 1000 })
    return Promise.reject(error)
});



