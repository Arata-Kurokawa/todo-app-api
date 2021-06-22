package controllers

import javax.inject._
import play.api.mvc._
import play.api.libs.json.Json
import play.filters.csrf._

import forms.SignInForm

class AuthController @Inject()(val controllerComponents: ControllerComponents) extends BaseController {
  def signIn() = Action { implicit req =>
    val form = SignInForm()
    val user = Map("id" -> 1, "email" -> "admin@todo.com", "password" -> "admintodo")

    // TODO 検証処理

    Ok(Json.toJson(Map("message"-> "sccess sign in"))).withSession(req.session + ("_uid" -> user.get("id").get.toString()))
  }

  def signOut() = Action { implicit req =>
    Ok(Json.toJson(Map("message"-> "sccess sign out"))).withSession(req.session - "_uid")
  }
}