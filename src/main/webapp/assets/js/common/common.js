
String.prototype.trim = function() {
	return this.replace(/(^\s*)|(\s*$)/g, "");
};
String.prototype.ltrim = function() {
	return this.replace(/(^\s*)/g, "");
};
String.prototype.rtrim = function() {
	return this.replace(/(\s*$)/g, "");
};

function toTrim(obj) {
	obj.value = obj.value.trim();
}

var specialCharacter = "×§·";
function stringCharLength(str) {
	var len = str.length;
	var num = 0;
	for (i = 0; i < len; i++) {
		var tmp = str.charCodeAt(i);
		if (tmp <= 255) {
			var temp = str.charAt(i);
			if (specialCharacter.indexOf(temp) >= 0) {
				num = num + 2;
			} else {
				num++;
			}
		} else
			num = num + 2;
	}
	return num;
}

function isNumberBLetter(keyCode) {
	if ((keyCode >= 48 && keyCode <= 57) || (keyCode >= 65 && keyCode <= 90)) {
		return true;
	}
	return false;
}

function isNumber(keyCode) {
    // 0123456789
	if (((keyCode >= 48 && keyCode <= 57) && (window.event.shiftKey == false))
			|| (keyCode >= 96 && keyCode <= 105))
		return true;
	return false;
}

function isCopy(keyCode) {
	if (window.event.ctrlKey == true && keyCode == 67)
		return true;
	return false;
}

function isPaste(keyCode) {
	if (window.event.ctrlKey == true && keyCode == 86)
		return true;
	return false;
}

function isLetter(keyCode) {
	if (keyCode >= 65 && keyCode <= 90)
		return true;
	return false;
}
function isSLetter(keyCode) {
	if (keyCode >= 97 && keyCode <= 122)
		return true;
	return false;
}

function isCursorCtrl(keyCode) {
	if (keyCode >= 33 && keyCode <= 40)
		return true;
	return false;
}

function isPlusSign(keyCode) {
	if ((keyCode == 187 || keyCode == 107) && window.event.shiftKey == true)
		return true;
	return false;
}

function isSubtractionSign(keyCode) {
	if ((keyCode == 109 || keyCode == 189) && window.event.shiftKey == false)
		return true;
	return false;
}

function isDotSign(keyCode) {
	if (keyCode == 110 || keyCode == 190)
		return true;
	return false;
}

function isTab(keyCode) {
	if (keyCode == 9)
		return true;
	return false;
}

function isEnter(keyCode) {
	if (keyCode == 13)
		return true;
	return false;
}

function isBackspace(keyCode) {
	if (keyCode == 8)
		return true;
	return false;
}

function isDelete(keyCode) {
	if (keyCode == 46)
		return true;
	return false;
}

function enterToTab() {
	if (window.event.keyCode == 13)
		window.event.keyCode = 9;
}

function isEscape(keyCode) {
	if (keyCode == 27)
		return true;
	return false;
}

function isDigitStr(s) {
	var patrn = /^(\d+)$/;
	if (!patrn.exec(s))
		return false;
	return true;
};

function strlen(str) {
	var i;
	var len;

	len = 0;
	for (i = 0; i < str.length; i++) {
		if (str.charCodeAt(i) > 255)
			len += 2;
		else
			len++;
	}
	return len;
}

function f_check_number(obj) {
	if (/^\d+$/.test(obj.value)) {
		return true;
	} else {
		// f_alert(obj,"请输入数字");
		return false;
	}
}

function f_check_lowercase(obj) {
	if (/^[a-z]+$/.test(obj.value)) {
		return true;
	}
	// f_alert(obj,"请输入小写英文字母");
	return false;
}

function f_check_uppercase(obj) {
	if (/^[A-Z]+$/.test(obj.value)) {
		return true;
	}
	// f_alert(obj,"请输入大写英文字母");
	return false;
}

function f_check_letter(obj) {
	if (/^[A-Za-z]+$/.test(obj.value)) {
		return true;
	}
	// f_alert(obj,"请输入英文字母");
	return false;
}

this.addZero2 = function(str) {
    var num = 0;
    num = parseInt(str);

    if (num < 10) {
        return "0" + str;
    }

    return str;
}
