const base = {
    get() {
        return {
            url : "http://localhost:8080/ssm21306/",
            name: "ssm21306",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/ssm21306/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "外卖商城平台的微信小程序"
        } 
    }
}
export default base
