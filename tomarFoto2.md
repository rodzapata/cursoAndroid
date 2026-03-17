if (ContextCompat.checkSelfPermission(
        this,
        Manifest.permission.ACCESS_FINE_LOCATION
    ) == PackageManager.PERMISSION_GRANTED) {

    getLocation()
}

private val requestPermission =
    registerForActivityResult(ActivityResultContracts.RequestPermission()) { granted ->
        if (granted) {
            getLocation()
        }
    }

val cameraLauncher =
    registerForActivityResult(ActivityResultContracts.TakePicturePreview()) { bitmap ->
        imageView.setImageBitmap(bitmap)
    }

cameraLauncher.launch(null)