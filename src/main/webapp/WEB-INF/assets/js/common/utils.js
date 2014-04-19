//register utility js.
(function() {
	var utils = {};
	$.extend({
		blogutils : utils
	});

	utils.isEmptyString = function(obj) {
		return obj == null || (this.isString(obj) && obj.trim().length == 0);
	};
	utils.isString = function(obj) {
		return typeof obj == "string";
	};
})();