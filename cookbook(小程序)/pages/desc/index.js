//index.js
const app = getApp()
const API = require('../../utils/api.js')
Page({
	data: {
    getByIdInfo:'',
    getAdres:''
	},
	onLoad: function () {
    this.getinfoById();
	},
  onReady: function () {
    
  },
	onShow:function(){

	},
  getinfoById:function(){
    this.setData({
      getByIdInfo: JSON.parse(getApp().getIdInfo)
    })
    console.log("123===="+this.data.getByIdInfo);
  },
  back:function(){
    //  this.setData({
    //   getAdres: getApp().getaddress
    // })
   wx.reLaunch({
     url: '/pages/index/index',
   })
  }
})
