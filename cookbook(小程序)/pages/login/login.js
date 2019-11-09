//index.js

Page({
  data: {
    aname:'',
    apwd:'',
    authorinfo:{}
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function () {

  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },
  login:function(){
    wx.request({
      url: 'http://127.0.0.1:8080/CookBook/getAuthorInfo.do', //仅为示例，并非真实的接口地址
      data: {
        aname:this.aname
      },
      header: {
        'content-type': 'application/json' // 默认值
      },
      success: (res) => {
        if (this.apwd == res.data.aPwd&&this.aname==res.data.aName&&res.data.state==0) {
          let authorinfo = JSON.stringify(res.data);
          let app=new getApp();
          app.getInfo=authorinfo;
         wx.reLaunch({
           url: '/pages/index/index'
         })
        }else{
          wx.showToast({
            title: '登录失败,账号或密码错误',
            icon: 'none',
            duration: 1000
          })
        }
      }
    })
  },
  getaName:function(ev){
    this.aname = ev.detail.value;
  },
  getaPwd:function(ev){
    this.apwd = ev.detail.value;
  }
})
