package com.psflickr.presentation.flickr.listing
import com.google.gson.Gson
import com.psflickr.data.flickr.entity.PhotoResponse

val gson = Gson()

fun photoResponse(): PhotoResponse =
    gson.fromJson<PhotoResponse>(
        "{\n" +
            "  \"photos\": {\n" +
            "    \"page\": 1,\n" +
            "    \"pages\": 10,\n" +
            "    \"perpage\": 100,\n" +
            "    \"total\": 1000,\n" +
            "    \"photo\": [\n" +
            "      {\n" +
            "        \"id\": \"51182147172\",\n" +
            "        \"owner\": \"182384452@N07\",\n" +
            "        \"secret\": \"2c5478fd53\",\n" +
            "        \"server\": \"65535\",\n" +
            "        \"farm\": 66,\n" +
            "        \"title\": \"chrome_RTZ1NLBWJe\",\n" +
            "        \"ispublic\": 1,\n" +
            "        \"isfriend\": 0,\n" +
            "        \"isfamily\": 0\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": \"51182147792\",\n" +
            "        \"owner\": \"189887645@N08\",\n" +
            "        \"secret\": \"6eaeb0306a\",\n" +
            "        \"server\": \"65535\",\n" +
            "        \"farm\": 66,\n" +
            "        \"title\": \"\",\n" +
            "        \"ispublic\": 1,\n" +
            "        \"isfriend\": 0,\n" +
            "        \"isfamily\": 0\n" +
            "      }\n" +
            "    ]\n" +
            "  },\n" +
            "  \"stat\": \"ok\"\n" +
            "}",
        PhotoResponse::class.java
    )