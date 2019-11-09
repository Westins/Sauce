// pages/about/about.js
//获取应用实例
const app = getApp()
const tools = require('../../utils/util.js')
Page({

  /**
   * 页面的初始数据
   */
  data: {
    auInfo: '',
    petname: '',
    email: '',
    sex: '',
    phone: '',
    auid: '',
    updInfo: ''
  },
  onLoad: function () {

  },
  onReady: function () {
    this.getAuInfo();
    this.updInfo();
  },
  getAuInfo: function () {
    this.setData({
      auInfo: JSON.parse(getApp().getInfo)
    })
  },
  updInfo: function (e) {
    console.log(e.detail.value)
    this.petname = e.detail.value.petName;
    this.email = e.detail.value.email;
    this.sex = e.detail.value.sex;
    this.phone = e.detail.value.phone;
    this.auid = e.detail.value.auid;
    wx.request({
      url: 'http://127.0.0.1:8080/CookBook/updAuInfo.do?name=' + this.petname + '&email=' + this.email +
        '&sex=' + this.sex + '&phone=' + this.phone + '&aid=' + this.auid, //仅为示例，并非真实的接口地址
      header: {
        'content-type': 'application/json' // 默认值
      },
      success:(res)=>{
        wx.reLaunch({
          url: '/pages/person/index',
        })
      }
    })
  }
})