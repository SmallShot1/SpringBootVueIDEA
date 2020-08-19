const api = {
    // 考试记录
    examrecordpage: 'examrecord/page',
    examrecordsave: 'examrecord/save',
    examrecorddelete: 'examrecord/delete',
    // 试卷
    exampaperpage: 'exampaper/page',
    exampaperinfo: 'exampaper/info/',
    exampapersave: 'exampaper/save',
    exampaperupdate: 'exampaper/update',
    exampaperdelete: 'exampaper/delete',
    // 试题
    examquestionpage: 'examquestion/page',
    examquestioninfo: 'examquestion/info/',
    examquestionsave: 'examquestion/save',
    examquestionupdate: 'examquestion/update',
    examquestiondelete: 'examquestion/delete',
    // 客服
    chatpage:'chat/page?sort=addtime&order=desc&isreply=1',
    chatbyuseridpage: 'chat/page?sort=addtime&order=asc&userid=',
    chatsave: 'chat/save',
    // 论坛
    forumpage: 'forum/page?parentid=0&sort=addtime&order=desc',
    forumdelete : 'forum/delete',
    forumsave: 'forum/save',
    foruminfo: 'forum/info/',
    forumupdate: 'forum/update',
    // 路线
    routepage : 'route/page',
    routedelete: 'route/delete',
    routeinfo: 'route/info/',
    routesave: 'route/save',
    routeupdate: 'route/update',
    // 配置
    configpage: 'config/page',
    configdelete: 'config/delete',
    configinfo: 'config/info/',
    configsave: 'config/save',
    configupdate: 'config/update',
    // 积分订单
    orderpage: 'orders/page',
    orderdelete: 'orders/delete',
    orderinfo: 'orders/info/',
    ordersave: 'orders/save',
    orderupdate: 'orders/update',
    // 座位预定
    seatspage: 'seats/page',
    seatsdelete: 'seats/delete',
    seatsinfo: 'seats/info/',
    seatssave: 'seats/save',
    seatsupdate: 'seats/update'
}

export default api