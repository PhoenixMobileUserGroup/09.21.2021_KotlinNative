import SwiftUI
import shared

struct ContentView: View {
	let greet = Greeting().greeting()
    

	var body: some View {
		Text(greet)
        Button("Get Image", action: )
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
	ContentView()
	}
}

extension ContentView {
    
    enum LoadableImage {
            case loading
            case result([shared.Image])
            case error(String)
        }
    
    class ViewModel: ObservableObject {
        let sdk: shared.CatApiController
        @Published var image = LoadableImage.loading

        init(sdk: shared.CatApiController) {
            self.sdk = sdk
            self.loadImage()
        }

        func loadImage() {
            self.image = .loading
                
            sdk.getImage(completionHandler: { image, error in
                if let image = image {
                    self.image = .result(image)
                } else {
                    self.image = .error(error?.localizedDescription ?? "error")
                }
            })
        }
   }
}
