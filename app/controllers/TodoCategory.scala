package controllers

import javax.inject._
import play.api.mvc._
import play.api.libs.json.Json

import scala.concurrent.ExecutionContext.Implicits.global

import model.JsValueTodoCategory
import useCases.TodoCategoryUseCase

class TodoCategoryController @Inject()(val controllerComponents: ControllerComponents) extends BaseController {
  def index() = Action.async { implicit req =>
    for {
      todoCategoryList <- TodoCategoryUseCase.all()
    } yield {
      val jsValSeq = todoCategoryList.map(JsValueTodoCategory(_))
      Ok(Json.toJson(jsValSeq))
    }
  }
}