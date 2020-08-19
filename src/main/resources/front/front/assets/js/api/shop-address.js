/**
 * 收货地址列表
 * @param {Object} page			页数
 * @param {Object} limit		条数
 * @param {Object} callback		回调
 */
function addressList(page, limit, callback) {
	httpJson(`address/list?page=${page}&limit=${limit}`, 'GET', '', callback);
}
/**
 * 添加地址
 * @param {Object} data			地址数据
 * @param {Object} callback		回调	
 */
function addressSave(data, callback) {
	httpJson(`address/add`, 'POST', data, callback);
}
/**
 * 更新地址数据
 * @param {Object} data			地址数据
 * @param {Object} callback		回调
 */
function addressUpdate(data, callback) {
	httpJson(`address/update`, 'POST', data, callback);
}
/**
 * 删除地址数据
 * @param {Object} ids			地址数据
 * @param {Object} callback		回调
 */
function addressDelete(ids, callback) {
	httpJson(`address/delete`, 'POST', ids, callback);
}

function addressInfo(id, callback) {
	httpJson(`address/detail/${id}`, 'POST', '', callback);
}
