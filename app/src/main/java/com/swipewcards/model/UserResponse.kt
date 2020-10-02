package com.swipewcards.model

import com.google.gson.annotations.SerializedName

data class UserResponse(

	@field:SerializedName("results")
	val results: List<ResultsItem?>? = null
)

data class Location(

	@field:SerializedName("zip")
	val zip: String? = null,

	@field:SerializedName("city")
	val city: String? = null,

	@field:SerializedName("street")
	val street: String? = null,

	@field:SerializedName("state")
	val state: String? = null
)

data class Name(

	@field:SerializedName("last")
	val last: String? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("first")
	val first: String? = null
)

data class User(

	@field:SerializedName("salt")
	val salt: String? = null,

	@field:SerializedName("gender")
	val gender: String? = null,

	@field:SerializedName("sha256")
	val sha256: String? = null,

	@field:SerializedName("registered")
	val registered: String? = null,

	@field:SerializedName("cell")
	val cell: String? = null,

	@field:SerializedName("picture")
	val picture: String? = null,

	@field:SerializedName("SSN")
	val sSN: String? = null,

	@field:SerializedName("sha1")
	val sha1: String? = null,

	@field:SerializedName("password")
	val password: String? = null,

	@field:SerializedName("phone")
	val phone: String? = null,

	@field:SerializedName("dob")
	val dob: String? = null,

	@field:SerializedName("name")
	val name: Name? = null,

	@field:SerializedName("location")
	val location: Location? = null,

	@field:SerializedName("email")
	val email: String? = null,

	@field:SerializedName("username")
	val username: String? = null,

	@field:SerializedName("md5")
	val md5: String? = null
)

data class ResultsItem(

	@field:SerializedName("seed")
	val seed: String? = null,

	@field:SerializedName("user")
	val user: User? = null,

	@field:SerializedName("version")
	val version: String? = null
)
