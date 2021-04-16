import React from "react";
import axios from "axios";
import BookListItem from "./BookListItem";
import BookListItemDetails from "./BookListItemDetails";
class BookList extends React.Component{
    state = {
        loading:false,
        results:[]
    }
    fetchData = () =>{
        this.setState({loading:true})
        axios.get("http://localhost:3305/book/all")
            .then(response => response.data)
            .then(data => {
                this.setState({results:data})
                this.setState({loading:false})
            })
    }
    componentDidMount() {
        this.fetchData()
    }

    render() {
        let list = this.state.results
            .sort(function (a,b){
                return a.name.localeCompare(b.name)
            })
            .map(r=><BookListItem data = {r}/>)
        return (
            <div className="container">
                {this.state.loading?
                    <div className="alert alert-warning" role="alert">
                        <p className="text-center mb-0">
                            Book list not available at the moment. Please try again later.
                        </p>
                    </div>
                    :
                    <ul className="list-group">
                        {list}
                    </ul>
                }
            </div>
        );
    }
}
export default BookList