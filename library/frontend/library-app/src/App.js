import HomeComponentMain from "./components/HomeComponent/HomeComponentMain";
import {BrowserRouter as Router, Route} from "react-router-dom";
import CategoryComponentMain from "./components/CategoryComponent/CategoryComponentMain";
import BooksMainComponent from "./components/BooksComponent/BooksMainComponent";
function App() {
  return (
    <div>
      <Router>
          <Route exact path="/" component={HomeComponentMain}/>
          <Route exact path="/books" component={BooksMainComponent}/>
          <Route exact path="/categories" component={CategoryComponentMain}/>
      </Router>
    </div>
  );
}

export default App;
