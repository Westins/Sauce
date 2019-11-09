//index.js
//获取应用实例
var app = getApp()
Page( {
 data:{
   auInfo:'',
   aInfo:'',
   showView: false,
   petname:'',
   email:'',
   sex:'',
   phone:'',
   auid:'',
   updInfo:'',
   aname:''

 },
  onLoad: function() {
   
  },
  onReady:function(){
    this.getAuInfo();
  },
  getAuInfo:function(){
    this.setData({
      aInfo: JSON.parse(getApp().getInfo)
    }),
    wx.request({
      
      url: 'http://127.0.0.1:8080/CookBook/getAuthorInfo.do',
      data: {
        aname: this.data.aInfo.aName
      },
      header: {
        'content-type': 'application/json' // 默认值
      },
      success:(res)=>{
        console.log(res.data)
        this.setData({
          auInfo: res.data
        })
      }
    })
    console.log(this.data.auInfo);
  },
  showButton: function () {
    wx.redirectTo({
      url: '/pages/about/about',
    })
  }
})