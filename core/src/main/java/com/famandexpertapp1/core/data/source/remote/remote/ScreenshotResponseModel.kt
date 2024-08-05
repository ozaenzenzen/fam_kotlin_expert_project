package com.famandexpertapp1.core.data.source.remote.remote

import com.google.gson.annotations.SerializedName

data class ScreenshotResponseModel(

	@field:SerializedName("ScreenshotResponseModel")
	val screenshotResponseModel: List<ScreenshotResponseModelItem?>? = null
)

data class ScreenshotResponseModelItem(

	@field:SerializedName("game")
	val game: Int? = null,

	@field:SerializedName("width")
	val width: Int? = null,

	@field:SerializedName("checksum")
	val checksum: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("image_id")
	val imageId: String? = null,

	@field:SerializedName("url")
	val url: String? = null,

	@field:SerializedName("height")
	val height: Int? = null,

	@field:SerializedName("alpha_channel")
	val alphaChannel: Boolean? = null,

	@field:SerializedName("animated")
	val animated: Boolean? = null
)
