package model

import play.api.libs.json._
// import play.api.libs.json.{Json, Writes}

import lib.model.TodoCategory

sealed case class JsValueTodoCategory (
  id: Long,
  name: String,
  slug: String,
  color: Short
)

object JsValueTodoCategory {
  implicit val writes: Writes[JsValueTodoCategory] = Json.writes[JsValueTodoCategory]

  def apply(todoCategory: TodoCategory.EmbeddedId): JsValueTodoCategory = {
    JsValueTodoCategory(
      todoCategory.id,
      todoCategory.v.name,
      todoCategory.v.slug,
      todoCategory.v.color.code,
    )
  }
}