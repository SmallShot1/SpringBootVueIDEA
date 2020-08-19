/**
 * 商品查询	
 * @param {Object} page		页数
 * @param {Object} limit	条数
 * @param {Object} callback	回调
 */
function goodsList(tablename,page,limit, searchname, searchval, callback){
	if(searchname){
		var url = `${tablename}/list?page=${page}&limit=${limit}&${searchname}=%${searchval}%`
		url = encodeURI(url)
		httpJson(url, 'GET', '', callback);
	}else{
		httpJson(`${tablename}/list?page=${page}&limit=${limit}`, 'GET', '', callback);
	}
}

/**
 * 商品详情
 * @param {Object} id			id
 * @param {Object} callback		回调
 */
function goodsInfo(tablename, id, callback){
	httpJson(`${tablename}/detail/${id}`, 'GET', '', callback);
}

function updateFun(tablename, data, callback){
	httpJson(`${tablename}/update`, 'POST', data, callback);
}
/**
 * 商品分类
 * @param {Object} id			id
 * @param {Object} callback		回调
 */
function tplist(tablename, page, limit, searchname, searchval, callback){
	if(searchname){
		var url = `${tablename}/list?page=${page}&limit=${limit}&${searchname}=${searchval}`
		url = encodeURI(url)
		httpJson(url, 'GET', '', callback);
	}else{
		httpJson(`${tablename}/list?page=${page}&limit=${limit}`, 'GET', '', callback);
	}
}

function tpDetail(tablename, id, callback){
	httpJson(`${tablename}/detail/${id}`, 'GET', '', callback);
}

function tpPage(tablename, callback){
	httpJson(`${tablename}/list?page=1`, 'GET', '', callback);
}

function addFun(tableName, data, callback) {
	httpJson(`${tableName}/add`, 'POST', data, callback);
}
// 投票
function voteFun(tableName, id, callback) {
	httpJson(`${tableName}/vote/{id}`, "GET", "", callback)
}

// 点赞
function thumbsUp(tableName, id, type, callback) {
	httpJson(`${tableName}/thumbsup/${id}?type=${type}`, 'GET', '', callback);
}

// 评论
function commentList(tableName, refid, callback) {
	httpJson(`discuss${tableName}/list?refid=${refid}`, 'GET', '', callback);
}

function addComment(tableName, data, callback) {
	httpJson(`discuss${tableName}/add`, 'POST', data, callback);
}

// 收藏
function storeUpAdd(tableName, data, callback) {
	httpJson(`storeup/add`, 'POST', data, callback);
}

// 新闻资讯
function newsList(callback) {
	httpJson(`news/list?page=1`, 'GET', '', callback);
}
function newsDetail(id, callback) {
	httpJson(`news/detail?id=${id}`, 'GET', '', callback);
}

// 获取某表某个字段列表
function getOption(tableName, columnName, callback){
	httpJson(`option/${tableName}/${columnName}`, 'GET', '', callback);
}

// 根据option字段值获取某表的单行记录
function getFollow(tableName, columnName, columnValue, callback){
	httpJson(`follow/${tableName}/${columnName}?columnValue=${columnValue}`, 'GET', '', callback);
}

// 客服
function kefuList(callback) {
	httpJson(`chat/list?page=1&sort=id&order=asc`, 'GET', "", callback)
}

function kefuAdd(data, callback) {
	httpJson(`chat/add`, 'POST', data, callback)
}
