package controllers

import javax.inject._
import play.api.mvc._
import play.api.libs.json.Json
import play.filters.csrf._
import play.filters.csrf.CSRF.Token

class CsrfTokenController @Inject()(val controllerComponents: ControllerComponents) extends BaseController {
  def index() = Action { implicit req =>
    val csrfToken = CSRF.getToken.get.value
    Ok(Json.toJson(Map("csrfToken" -> csrfToken)))
      .withCookies(Cookie("csrfToken", csrfToken, httpOnly = false))
  }
}