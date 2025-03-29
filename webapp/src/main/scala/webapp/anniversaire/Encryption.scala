package anniversaire
import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import scala.util.Try

@js.native
@JSImport("crypto-js", JSImport.Namespace)
object CryptoJS extends js.Object {
  val AES: AES = js.native
  val enc: Encoding = js.native
  val SHA256: SHA256 = js.native
}

@js.native
trait AES extends js.Object {
  def encrypt(message: String, key: String): js.Dynamic = js.native
  def decrypt(ciphertext: String, key: String): js.Dynamic = js.native
}

@js.native
trait Encoding extends js.Object {
  val Utf8: js.Dynamic = js.native
}

@js.native
trait SHA256 extends js.Object {
  def apply(message: String): js.Dynamic = js.native
}

object AESUtil {
  def encryptAES(input: String, key: String): String = {
    val encrypted = CryptoJS.AES.encrypt(input, key)
    encrypted.toString()
  }

  def decryptAES(encryptedInput: String, key: String): Option[String] = {
    val decrypted = CryptoJS.AES.decrypt(encryptedInput, key)
    Try {
      decrypted
        .asInstanceOf[js.Dynamic]
        .applyDynamic("toString")(CryptoJS.enc.Utf8)
        .asInstanceOf[String]
    }.toOption
  }
}

object HashUtil {
  def sha256(input: String): String = {
    CryptoJS.SHA256(input).toString()
  }
}
