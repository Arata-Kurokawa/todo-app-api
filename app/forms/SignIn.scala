package forms

import play.api.data._
import play.api.data.Forms._
import play.api.data.validation.Constraints._

case class SignInData(email: String, password: String)

object SignInForm {
  def apply(): Form[SignInData] = {
    Form(
      mapping(
        "email"  -> nonEmptyText,
        "password"  -> nonEmptyText
      )(SignInData.apply)(SignInData.unapply)
    )
  }
}
