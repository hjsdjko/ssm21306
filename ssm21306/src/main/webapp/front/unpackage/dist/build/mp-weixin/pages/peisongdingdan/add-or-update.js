(global["webpackJsonp"]=global["webpackJsonp"]||[]).push([["pages/peisongdingdan/add-or-update"],{"25d8":function(n,e,i){},"6df0":function(n,e,i){"use strict";(function(n){Object.defineProperty(e,"__esModule",{value:!0}),e.default=void 0;var r=t(i("a34a"));function t(n){return n&&n.__esModule?n:{default:n}}function a(n,e,i,r,t,a,o){try{var u=n[a](o),g=u.value}catch(s){return void i(s)}u.done?e(g):Promise.resolve(g).then(r,t)}function o(n){return function(){var e=this,i=arguments;return new Promise((function(r,t){var o=n.apply(e,i);function u(n){a(o,r,t,u,g,"next",n)}function g(n){a(o,r,t,u,g,"throw",n)}u(void 0)}))}}var u=function(){Promise.all([i.e("common/vendor"),i.e("components/w-picker/w-picker")]).then(function(){return resolve(i("bb30"))}.bind(null,i)).catch(i.oe)},g={data:function(){return{ruleForm:{dingdanbianhao:this.getUUID(),shangpinmingcheng:"",shangpinleixing:"",zhanghao:"",zongjiage:"",peisongfei:"",goumairiqi:"",yonghuming:"",xingming:"",shouji:"",dizhi:"",peisongzhuangtai:"",peisongneirong:"",gonghao:"",qishouxingming:"",sfsh:"",shhf:"",userid:""},peisongzhuangtaiOptions:[],peisongzhuangtaiIndex:0,user:{},ro:{dingdanbianhao:!1,shangpinmingcheng:!1,shangpinleixing:!1,zhanghao:!1,zongjiage:!1,peisongfei:!1,goumairiqi:!1,yonghuming:!1,xingming:!1,shouji:!1,dizhi:!1,peisongzhuangtai:!1,peisongneirong:!1,gonghao:!1,qishouxingming:!1,sfsh:!1,shhf:!1,userid:!1}}},components:{wPicker:u},computed:{},onLoad:function(e){var i=this;return o(r.default.mark((function t(){var a,o,u,g;return r.default.wrap((function(t){while(1)switch(t.prev=t.next){case 0:return a=n.getStorageSync("nowTable"),t.next=3,i.$api.session(a);case 3:if(o=t.sent,i.user=o.data,i.ruleForm.gonghao=i.user.gonghao,i.ruleForm.qishouxingming=i.user.qishouxingming,i.peisongzhuangtaiOptions="备货中,已取货,配送中,已送达".split(","),i.ruleForm.userid=n.getStorageSync("userid"),e.refid&&(i.ruleForm.refid=e.refid,i.ruleForm.nickname=n.getStorageSync("nickname")),!e.id){t.next=16;break}return i.ruleForm.id=e.id,t.next=14,i.$api.info("peisongdingdan",i.ruleForm.id);case 14:o=t.sent,i.ruleForm=o.data;case 16:if(!e.cross){t.next=87;break}u=n.getStorageSync("crossObj"),t.t0=r.default.keys(u);case 19:if((t.t1=t.t0()).done){t.next=87;break}if(g=t.t1.value,"dingdanbianhao"!=g){t.next=25;break}return i.ruleForm.dingdanbianhao=u[g],i.ro.dingdanbianhao=!0,t.abrupt("continue",19);case 25:if("shangpinmingcheng"!=g){t.next=29;break}return i.ruleForm.shangpinmingcheng=u[g],i.ro.shangpinmingcheng=!0,t.abrupt("continue",19);case 29:if("shangpinleixing"!=g){t.next=33;break}return i.ruleForm.shangpinleixing=u[g],i.ro.shangpinleixing=!0,t.abrupt("continue",19);case 33:if("zhanghao"!=g){t.next=37;break}return i.ruleForm.zhanghao=u[g],i.ro.zhanghao=!0,t.abrupt("continue",19);case 37:if("zongjiage"!=g){t.next=41;break}return i.ruleForm.zongjiage=u[g],i.ro.zongjiage=!0,t.abrupt("continue",19);case 41:if("peisongfei"!=g){t.next=45;break}return i.ruleForm.peisongfei=u[g],i.ro.peisongfei=!0,t.abrupt("continue",19);case 45:if("goumairiqi"!=g){t.next=49;break}return i.ruleForm.goumairiqi=u[g],i.ro.goumairiqi=!0,t.abrupt("continue",19);case 49:if("yonghuming"!=g){t.next=53;break}return i.ruleForm.yonghuming=u[g],i.ro.yonghuming=!0,t.abrupt("continue",19);case 53:if("xingming"!=g){t.next=57;break}return i.ruleForm.xingming=u[g],i.ro.xingming=!0,t.abrupt("continue",19);case 57:if("shouji"!=g){t.next=61;break}return i.ruleForm.shouji=u[g],i.ro.shouji=!0,t.abrupt("continue",19);case 61:if("dizhi"!=g){t.next=65;break}return i.ruleForm.dizhi=u[g],i.ro.dizhi=!0,t.abrupt("continue",19);case 65:if("peisongzhuangtai"!=g){t.next=69;break}return i.ruleForm.peisongzhuangtai=u[g],i.ro.peisongzhuangtai=!0,t.abrupt("continue",19);case 69:if("peisongneirong"!=g){t.next=73;break}return i.ruleForm.peisongneirong=u[g],i.ro.peisongneirong=!0,t.abrupt("continue",19);case 73:if("gonghao"!=g){t.next=77;break}return i.ruleForm.gonghao=u[g],i.ro.gonghao=!0,t.abrupt("continue",19);case 77:if("qishouxingming"!=g){t.next=81;break}return i.ruleForm.qishouxingming=u[g],i.ro.qishouxingming=!0,t.abrupt("continue",19);case 81:if("userid"!=g){t.next=85;break}return i.ruleForm.userid=u[g],i.ro.userid=!0,t.abrupt("continue",19);case 85:t.next=19;break;case 87:i.styleChange();case 88:case"end":return t.stop()}}),t)})))()},methods:{styleChange:function(){this.$nextTick((function(){}))},peisongzhuangtaiChange:function(n){this.peisongzhuangtaiIndex=n.target.value,this.ruleForm.peisongzhuangtai=this.peisongzhuangtaiOptions[this.peisongzhuangtaiIndex]},getUUID:function(){return(new Date).getTime()},onSubmitTap:function(){var n=this;return o(r.default.mark((function e(){return r.default.wrap((function(e){while(1)switch(e.prev=e.next){case 0:if(n.ruleForm.shangpinmingcheng){e.next=3;break}return n.$utils.msg("商品名称不能为空"),e.abrupt("return");case 3:if(n.ruleForm.shangpinleixing){e.next=6;break}return n.$utils.msg("商品类型不能为空"),e.abrupt("return");case 6:if(n.ruleForm.peisongfei){e.next=9;break}return n.$utils.msg("配送费不能为空"),e.abrupt("return");case 9:if(!n.ruleForm.peisongfei||n.$validate.isIntNumer(n.ruleForm.peisongfei)){e.next=12;break}return n.$utils.msg("配送费应输入整数"),e.abrupt("return");case 12:if(n.ruleForm.dizhi){e.next=15;break}return n.$utils.msg("地址不能为空"),e.abrupt("return");case 15:if(!n.ruleForm.id){e.next=20;break}return e.next=18,n.$api.update("peisongdingdan",n.ruleForm);case 18:e.next=22;break;case 20:return e.next=22,n.$api.add("peisongdingdan",n.ruleForm);case 22:n.$utils.msgBack("提交成功");case 23:case"end":return e.stop()}}),e)})))()},optionsChange:function(n){this.index=n.target.value},bindDateChange:function(n){this.date=n.target.value},getDate:function(n){var e=new Date,i=e.getFullYear(),r=e.getMonth()+1,t=e.getDate();return"start"===n?i-=60:"end"===n&&(i+=2),r=r>9?r:"0"+r,t=t>9?t:"0"+t,"".concat(i,"-").concat(r,"-").concat(t)},toggleTab:function(n){this.$refs[n].show()}}};e.default=g}).call(this,i("543d")["default"])},"71fc":function(n,e,i){"use strict";(function(n){i("c2a9");r(i("66fd"));var e=r(i("efa2"));function r(n){return n&&n.__esModule?n:{default:n}}n(e.default)}).call(this,i("543d")["createPage"])},"7b5d":function(n,e,i){"use strict";i.r(e);var r=i("6df0"),t=i.n(r);for(var a in r)"default"!==a&&function(n){i.d(e,n,(function(){return r[n]}))}(a);e["default"]=t.a},"9c84":function(n,e,i){"use strict";var r;i.d(e,"b",(function(){return t})),i.d(e,"c",(function(){return a})),i.d(e,"a",(function(){return r}));var t=function(){var n=this,e=n.$createElement;n._self._c},a=[]},ae99:function(n,e,i){"use strict";var r=i("25d8"),t=i.n(r);t.a},efa2:function(n,e,i){"use strict";i.r(e);var r=i("9c84"),t=i("7b5d");for(var a in t)"default"!==a&&function(n){i.d(e,n,(function(){return t[n]}))}(a);i("ae99");var o,u=i("f0c5"),g=Object(u["a"])(t["default"],r["b"],r["c"],!1,null,"2b3132ce",null,!1,r["a"],o);e["default"]=g.exports}},[["71fc","common/runtime","common/vendor"]]]);