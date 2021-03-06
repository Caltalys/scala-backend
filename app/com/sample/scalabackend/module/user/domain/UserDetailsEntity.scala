package com.sample.scalabackend.module.user.domain

import com.sample.scalabackend.core.Asserts
import com.sample.scalabackend.core.Asserts
import play.api.libs.json.Json

case class UserDetailsEntity
(
  id        : Long,
  firstName : String,
  lastName  : String,
  username  : String,
  email     : String,
  password  : String
)
{
  selfReference =>
  Asserts.argumentIsNotNull(firstName)
  Asserts.argumentIsNotNull(lastName)
  Asserts.argumentIsNotNull(email)
  Asserts.argumentIsNotNull(username)
  Asserts.argumentIsNotNull(password)

  lazy val withoutPassword = selfReference.copy(password = "n/a")
}

object UserDetailsEntity
{
  implicit val jsonFormat = Json.format[UserDetailsEntity]
}