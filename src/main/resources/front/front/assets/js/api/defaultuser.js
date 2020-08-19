/**
 * 登录
 */
function login(tablename, data, callback) {
	http(`${tablename}/login`, 'GET', data, callback)
}
/**
 * 用户个人信息
 */
function session(tablename, callback) {
	httpJson(`${tablename}/session`, 'GET', '', callback)
}
/**
 * 更新用户信息
 * @param {Object} tablename	用户表名
 * @param {Object} data			用户数据
 * @param {Object} callback		回调
 */
function updateUser(tablename, data, callback) {
	httpJson(`${tablename}/update`, 'POST', data, callback);
}
/**
 * 注册
 * @param {Object} tablename	用户表名
 * @param {Object} username		用户名
 * @param {Object} password		密码
 * @param {Object} callback		回调
 */
function register(tablename, data, callback) {
	httpJson(`${tablename}/register`, 'POST', data, callback);
}
/**
 * 重置密码
 * @param {Object} tablename	表名
 * @param {Object} username		账户名
 */
function resetPass(tablename, data, callback) {
	http(`${tablename}/resetPass`, 'GET', data, callback);
}
