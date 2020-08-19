/**
 * 购物车列表
 * @param {Object} page			页数
 * @param {Object} limit		条数
 * @param {Object} callback		回调
 */
function cartList(page, limit, callback) {
	httpJson(`cart/list?page=${page}&limit=${limit}`, 'GET', '', callback);
}
/**
 * 添加到购物车
 * @param {Object} data			购物车数据
 * @param {Object} callback		回调	
 */
function cartSave(data, callback) {
	httpJson(`cart/add`, 'POST', data, callback);
}
/**
 * 更新购物车数据
 * @param {Object} data			购物车数据
 * @param {Object} callback		回调
 */
function cartUpdate(data, callback) {
	httpJson(`cart/update`, 'POST', data, callback);
}
/**
 * 删除购物车数据
 * @param {Object} ids			id数组数据
 * @param {Object} callback		回调
 */
function cartDelete(ids, callback) {
	httpJson(`cart/delete`, 'POST', ids, callback);
}