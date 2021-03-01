package skywolf46.adl.abstraction.files

import skywolf46.adl.abstraction.AbstractDataSnapshot
import java.io.DataOutputStream
import java.io.File
import java.io.FileOutputStream
import java.nio.charset.StandardCharsets

abstract class AbstractFileBasedSnapshot(protected val fx: File) : AbstractDataSnapshot<File>(fx) {
    override fun saveSnapshot() {
        if (!fx.exists()) {
            fx.parentFile.mkdirs()
            fx.createNewFile()
        }
        save(DataOutputStream(FileOutputStream(fx)))
    }

    abstract fun save(stream: DataOutputStream)
}