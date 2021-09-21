import SwiftUI
import shared

struct ContentView: View {
    @ObservedObject private(set) var viewModel: ViewModel

	var body: some View {
        VStack{
            if (viewModel.loading){
                ProgressView("Loading...")
                    .frame(width: 400.0, height: 400.0)
            } else {
                Image(uiImage: viewModel.image.load())
                    .resizable()
                    .frame(width: 400.0, height: 400.0)
            }
        }
        Button("Get Image", action: self.viewModel.loadImage)
	}
}

extension String {
    func load() -> UIImage{
        do {
            guard let url = URL(string: self) else {
                return UIImage()
            }
            let data: Data = try Data(contentsOf: url)
            
            return UIImage(data: data) ?? UIImage()
        } catch {
            
        }
        return UIImage()
    }
}

extension ContentView {
    
    enum LoadableImage {
            case loading(String)
            case result(String)
            case error(String)
        }
    
    class ViewModel: ObservableObject {
        let sdk: shared.CatApiController
        @Published var image = ""
        @Published var loading = true

        init(sdk: shared.CatApiController) {
            self.sdk = sdk
            self.loadImage()
        }

        func loadImage() {
            self.image = "Loading..."
            self.loading = true
                
            sdk.getImage(completionHandler: { image, error in
                if let image = image {
                    self.image = image[0].url
                    self.loading = false
                } else {
                    self.image = error?.localizedDescription ?? "error"
                    self.loading = false
                }
            })
        }
   }
}
