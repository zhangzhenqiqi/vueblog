import { createStore } from 'vuex'

export default createStore({
  state: {
    token: '',
    userInfo: JSON.parse(sessionStorage.getItem("userInfo"))
  },
  mutations: {
    SET_TOKEN: (state, token) => {
      state.token = token;
      localStorage.setItem("token", token);
    },
    SET_USERINFO: (state, userInfo) => {
      state.userInfo = userInfo
      sessionStorage.setItem("userInfo", JSON.stringify(userInfo))
    },
    /*
      存储token使用localStorage
      存储用户信息用sessionStorage
    */ 
    REMOVE_INFO: (state) => {
      localStorage.setItem("token", '')
      sessionStorage.setItem("userInfo", JSON.stringify(''))
      state.userInfo = {}
    }
  },
  getters: {
    getUser: state => {
      return state.userInfo
    }
  },
  actions: {
  },
  modules: {
  }
})
