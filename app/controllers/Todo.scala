package controllers

import javax.inject._
import play.api.mvc._
import play.api.libs.json.Json

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

import model.JsValueTodo
import useCases.TodoUseCase
import forms.TodoForm

class TodoController @Inject()(val controllerComponents: ControllerComponents) extends BaseController {

  def index() = Action.async { implicit req =>
    for {
      todoList <- TodoUseCase.all()
    } yield {
      val jsValSeq = todoList.map(JsValueTodo(_))
      Ok(Json.toJson(jsValSeq))
    }
  }

  def create() = Action.async { implicit req =>
    val form = TodoForm.add
    form.bindFromRequest.fold(
      formWithErrors => {
        Future {
          BadRequest(Json.toJson(Map("error" -> "invaild")))
        }
      },
      todoData => {
        for {
          id <- TodoUseCase.create(todoData.title, todoData.body, todoData.categoryId)
        } yield {
          /* binding success, you get the actual value. */
          Ok(Json.toJson(id.toLong))
        }
      }
    )
  }
}