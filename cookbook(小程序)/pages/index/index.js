//index.js
const app = getApp()
const API = require('../../utils/api.js')
Page({
	data: {
		swiperList: [{
		id: 0,
		url: '/img/1.jpg'
		}, {
		id: 1,
        url: '/img/2.jpg',
		}, {
		id: 2,
        url: '/img/3.jpg'
		}, {
		id: 3,
        url: '/img/4.jpg'
		}, {
		id: 4,
        url: '/img/5.jpg'
		}],
		searchResult: null,
		result: false,
    authorinfo: '',
    cbList: '',
    
	},
	onLoad: function () {
	},
  onReady: function () {
    this.getAllCook();
  },
	onShow:function(){
	},
	// 自定义方法
	//事件处理函数

  //获取所有信息
  getAllCook: function () {
    wx.request({
      url: 'http://127.0.0.1:8080/CookBook/getckInfo.do', //仅为示例，并非真实的接口地址
      header: {
        'content-type': 'application/json' // 默认值
      },
      success: (res) => {
        console.log(res.data)
        this.setData({
          cbList: res.data
        })
      }
    })
  },
	// 文章详情
	showArticle:function (e) {
	  console.log(e)
		console.log(e.currentTarget.dataset.id)
    wx.request({
      url: 'http://127.0.0.1:8080/CookBook/getById.do?id=' + e.currentTarget.dataset.id,

      header: {
        'content-type': 'application/json' // 默认值
      },
      success:(res)=>{
        let getById = JSON.stringify(res.data);
        let app = new getApp();
        app.getIdInfo = getById;
       wx.reLaunch({
         url: '/pages/articleContent/articleContent'
       })
      }
    })
	}
})
