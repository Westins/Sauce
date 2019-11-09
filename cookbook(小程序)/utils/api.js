const base_url = "http://xxx.com/xxx";
const DEBUG = true;//切换数据入口
const Mock = require('mock.js')
function ajax(url, data = '', method = "get", fn,  header = {}) {
    return new Promise(function (resolve, reject){
        if (!DEBUG) {
            wx.request({
                url: base_url + url,
                method: method ? method : 'get',
                data: {},
                header: header ? header : { "Content-Type": "application/json" },
                success: function (res) {
                    fn(res);
                },
				fail: function(err){
					reject(err)
					wx.showToast({
						title: '网络请求失败！请稍后再试',
						icon: 'none',
						duration: 3000
					})
				}
            });
        } else {
            // 模拟数据
            let res = Mock.mock({
                'state_code': '200',
                'state_msg': 'success',
                'data|6': [{
                    'id|+1': 1,
                    'isTop|1-5': true,
					'thumb': Mock.Random.image('1000x500', '#50B347', '#FFF','png', 'Mock.js'),
                    'title': '@ctitle(3,30)',
					'author': '@cname()',
					'authorHead': Mock.Random.image('120x120', '#FF6600', '#FFF', 'png', 'Z'),
					'tags':['html','css','javascript'],
					'resultShow': false,
                    'describe': "@csentence(10, 50)",
					'content': '@cparagraph(2, 5)',
                    'addTime': '@datetime()',
                    'updateTime': '@now()',
                    'scanned': '@integer(0,100)',
                    'like': '@integer(0,100)',
                    'message': '@integer(0,100)'
                }]
            })
            // 输出结果
            // console.log(res)
            fn(res);
		}
        resolve('200 OK');
    }).catch((err)=>{
        console.log(err)
    })
}
module.exports = {
    ajax: ajax
}