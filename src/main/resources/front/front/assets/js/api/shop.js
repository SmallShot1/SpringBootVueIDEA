/**
 * 推荐商品
 * @param {Object} tablename	表名
 * @param {Object} page			页数
 * @param {Object} limit		条数 
 * @param {Object} callback		回调
 */
function recommend(tablename, type ,callback) {
	if(!type){
		httpJson(`${tablename}/list?page=1&limit=6`, 'GET', '', callback);
	}else{
		httpJson(`${tablename}/autoSort?limit=6`, 'GET', '', callback);
	}
}
