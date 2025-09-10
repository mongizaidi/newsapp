# News App

A Simple Android application that displays the latest news headlines using the NewsAPI. Built with Kotlin and following Android development best practices.

## Features

- 📰 **Latest News Headlines** - View current news articles with images and descriptions
- 🔍 **Article Details** - Tap any article to view full details including source links
- 🔄 **Pull-to-Refresh** - Swipe down to refresh the news feed
- 🌐 **Network Error Handling** - Graceful error handling with retry functionality
- 📱 **Material Design** - Clean, modern UI following Google's Material Design guidelines
- 🔒 **Secure API Integration** - API keys stored securely using BuildConfig

## Architecture

This project follows the **MVVM (Model-View-ViewModel)** architecture pattern with the following key components:

### Architecture Components

- **Model**: Data classes representing API responses (`Article`, `NewsResponse`, `APIError`)
- **View**: Activities and layouts with Data Binding
- **ViewModel**: Business logic and state management (`MainViewModel`, `ArticleDetailsViewModel`)
- **Repository**: Data access layer (`NewsRepository`)
- **Network**: API service layer with Retrofit and OkHttp

### Key Design Decisions

**Why MVVM?**
- Clear separation of concerns
- Testable business logic
- Lifecycle-aware components
- Data binding integration

**Why Hilt for Dependency Injection?**
- Compile-time safety
- Easy testing with mock objects
- Reduced boilerplate code
- Official Google recommendation

**Why Retrofit + OkHttp?**
- Type-safe HTTP client
- Built-in JSON parsing
- Interceptor support for logging and authentication
- Excellent error handling capabilities

## Technical Implementation

### Dependencies

- **UI**: Material Design Components, Data Binding, View Binding
- **Architecture**: ViewModel, LiveData, Hilt
- **Network**: Retrofit, OkHttp, Gson
- **Image Loading**: Glide
- **Testing**: JUnit, Mockito, Coroutines Test

### Project Structure

```
app/src/main/java/m/z/newsapp/
├── adapter/          # RecyclerView adapters
├── di/              # Dependency injection modules
├── model/           # Data models
├── network/         # API service and repository
├── ui/
│   ├── activity/    # Activities
│   └── application/ # Application class
├── util/            # Utility classes and binding adapters
└── viewmodel/       # ViewModels
```

### API Integration

The app integrates with [NewsAPI](https://newsapi.org/) to fetch top headlines. Key features:

- **Language Support**: Currently configured for English (API limitation)
- **Error Handling**: Comprehensive error handling for network issues
- **Rate Limiting**: Proper handling of API rate limits
- **Security**: API key stored securely in BuildConfig

## Setup Instructions

### Prerequisites

- Android Studio Arctic Fox or later
- JDK 11 or later
- Android SDK 24+ (Android 7.0)

### Installation

1. **Clone the repository**
   ```bash
   git clone https://github.com/mongizaidi/newsapp.git
   cd newsapp
   ```

2. **Get NewsAPI Key**
   - Visit [NewsAPI](https://newsapi.org/) and register for a free API key
   - Add your API key to `local.properties`:
   ```properties
   NEWS_API_KEY=your_api_key_here
   ```

3. **Build and Run**
   ```bash
   ./gradlew assembleDebug
   ```

### Configuration

The app uses the following configuration:

- **Min SDK**: 24 (Android 7.0)
- **Target SDK**: 36 (Android 14)
- **Language**: Kotlin
- **Build System**: Gradle with Version Catalog

## Testing

The project includes comprehensive unit tests covering:

- **ViewModels**: TBD
- **Repository**: TBD
- **Models**: Data class functionality
- **Adapters**: UI component testing

Run tests with:
```bash
./gradlew test
```

## Error Handling

The app implements robust error handling for various scenarios:

- **Network Errors**: Connection timeouts, server errors
- **API Errors**: Invalid responses, rate limiting
- **Data Errors**: Empty results, parsing failures
- **User Experience**: Clear error messages with retry options

## Future Enhancements

While this is a technical test implementation, in a production environment I would consider:

- **Offline Support**: Local caching with Room database
- **Search Functionality**: Article search and filtering
- **Categories**: News categorization (sports, technology, etc.)
- **Favorites**: Save articles for later reading
- **Push Notifications**: Breaking news alerts
- **Dark Theme**: User preference for dark/light mode
- **Internationalization**: Multi-language support

## Known Limitations

- **Language Support**: Currently limited to English due to API constraints
- **Offline Mode**: No offline caching implemented
- **Pagination**: Single page of results (20 articles)
- **Image Caching**: Basic image loading without advanced caching

## Contributing

This is a technical test project, but if you'd like to suggest improvements:

1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Add tests for new functionality
5. Submit a pull request

## License

This project is for demonstration purposes as part of a technical interview process.

## Contact

Created by Mongi Zaidi - [LinkedIn](https://linkedin.com/in/mongizaidi) | [GitHub](https://github.com/mongizaidi)

---

*Built with ❤️ using modern Android development practices*
