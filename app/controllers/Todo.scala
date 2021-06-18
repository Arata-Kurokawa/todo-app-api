package controllers

import javax.inject._
import play.api.mvc._
import play.api.libs.json.Json

import scala.concurrent.ExecutionContext.Implicits.global

import model.JsValueTodo
import useCases.TodoUseCase


class TodoController @Inject()(val controllerComponents: ControllerComponents) extends BaseController {

  def index() = Action.async { implicit req =>
    for {
      todoList <- TodoUseCase.all()
    } yield {
      val jsValSeq = todoList.map(JsValueTodo(_))
      Ok(Json.toJson(jsValSeq))
    }
  }
}