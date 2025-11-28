package org.ldv.proje_ecommerce.admincontrollers

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
open class AdminController {

    @GetMapping("/admin")
    open fun dashboard(): String {
        return "pageAdmin/dashboard"
    }
}
