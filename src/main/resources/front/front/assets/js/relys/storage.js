	function setStorage(key, value) {
        localStorage.setItem(key, JSON.stringify(value));
    }
    function getStorage(key) {
        return localStorage.getItem(key)?localStorage.getItem(key).replace('"','').replace('"',''):"";
    }
     function getStorageObj(key) {
        return localStorage.getItem(key)?JSON.parse(localStorage.getItem(key)):null;
    }
     function removeStorage(key) {
        localStorage.removeItem(key);
    }