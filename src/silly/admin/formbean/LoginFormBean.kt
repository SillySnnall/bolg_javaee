package silly.admin.formbean

import silly.util.isPhone

data class LoginFormBean(
        var user_name: String = "",
        var password: String = "",
        var errors: String = ""
) {
    fun validate(): Boolean {
        if (this.user_name.trim() == "") {
            errors = "手机号不能为空"
            return false
        } else {
            if (!isPhone(this.user_name)) {
                errors = "请填写正确的手机号"
                return false
            }
        }

        if (this.password.trim() == "") {
            errors = "密码不能为空"
            return false
        } else {
            if (!this.password.matches("[0-9a-zA-Z]{3,16}".toRegex())) {
                errors = "密码必须是3-16位的数字、字母"
                return false
            }
        }
        return true
    }

}

