package model

import play.api.libs.json._
// import play.api.libs.json.{Json, Writes}


import lib.model.Todo

sealed case class JsValueTodo(
  id: Long,
  title: String,
  body: String,
  state: Short
)

object JsValueTodo {
  implicit val writes: Writes[JsValueTodo] = Json.writes[JsValueTodo]

  def apply(todo: Todo.EmbeddedId): JsValueTodo = {
    JsValueTodo(
      todo.id,
      todo.v.title,
      todo.v.body,
      todo.v.state.code,
    )
  }
}