val imageCapture = ImageCapture.Builder().build()

val photoFile = File(
    externalMediaDirs.first(),
    "foto_${System.currentTimeMillis()}.jpg"
)

val outputOptions = ImageCapture.OutputFileOptions.Builder(photoFile).build()

imageCapture.takePicture(
    outputOptions,
    ContextCompat.getMainExecutor(this),
    object : ImageCapture.OnImageSavedCallback {

        override fun onImageSaved(output: ImageCapture.OutputFileResults) {
            println("Foto guardada: ${photoFile.absolutePath}")
        }

        override fun onError(exception: ImageCaptureException) {
            println("Error: ${exception.message}")
        }
    }
)