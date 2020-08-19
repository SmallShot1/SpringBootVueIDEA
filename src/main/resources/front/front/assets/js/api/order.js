/**
 * 订单列表
 * @param {Object} page			页数
 * @param {Object} limit		条数
 * @param {Object} callback		回调
 */
function ordersList(page, limit, status, callback) {
	if(status=="全部"){
		httpJson(`orders/list?page=${page}&limit=${limit}`, 'GET', '', callback);
	}else{
		httpJson(`orders/list?page=${page}&limit=${limit}&status=${status}`, 'GET', '', callback);
	}
	
}
/**
 * 添加订单
 * @param {Object} data			订单数据
 * @param {Object} callback		回调	
 */
function ordersSave(data, callback) {
	httpJson(`orders/add`, 'POST', data, callback);
}
/**
 * 更新订单数据
 * @param {Object} data			订单数据
 * @param {Object} callback		回调
 */
function ordersUpdate(data, callback) {
	httpJson(`orders/update`, 'POST', data, callback);
}
/**
 * 删除订单数据
 * @param {Object} ids			订单数组
 * @param {Object} callback		回调
 */
function ordersDelete(ids, callback) {
	httpJson(`orders/delete`, 'POST', ids, callback);
}
/**
 * 订单详情
 * @param {Object} id			订单id
 * @param {Object} callback		回调
 */
function ordersInfo(id, callback) {
	httpJson(`orders/detail/${id}`, 'POST', '', callback);
}
