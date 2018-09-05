package silly.admin.formbean

import silly.util.isPhone

data class RegisterFormBean(
        var user_name: String = "",
        var password: String = "",
        var code: String = "",
        var type: String = "",
        var errors: String = ""
) {
    fun validate(): Boolean {
        if (this.user_name.trim() == "") {
            this.errors = "手机号不能为空"
            return false
        } else {
            if (!isPhone(this.user_name)) {
                this.errors = "请填写正确的手机号"
                return false
            }
        }

        if (this.type.equals("获取")) return true

        if (this.password.trim() == "") {
            this.errors = "密码不能为空"
            return false
        } else {
            if (!this.password.matches("[0-9a-zA-Z]{3,16}".toRegex())) {
                this.errors = "密码必须是3-16位的数字、字母"
                return false
            }
        }

        if (this.code.trim() == "") {
            this.errors = "验证码不能为空"
            return false
        }
        return true
    }

}

