package me.metumortis.deneme

import java.security.MessageDigest


class HWID {
    companion object{
        fun getHWID(): String? {
            return try {
                val toEncrypt =
                    System.getenv("COMPUTERNAME") + System.getProperty("user.name") + System.getenv("PROCESSOR_IDENTIFIER") + System.getenv(
                        "PROCESSOR_LEVEL"
                    )
                val md = MessageDigest.getInstance("MD5")
                md.update(toEncrypt.toByteArray())
                val hexString = StringBuffer()
                val byteData = md.digest()
                for (aByteData in byteData) {
                    val hex = Integer.toHexString(0xff and aByteData.toInt())
                    if (hex.length == 1) hexString.append('0')
                    hexString.append(hex)
                }
                hexString.toString()
            } catch (e: Exception) {
                e.printStackTrace()
                "Error"
            }
        }
    }
}