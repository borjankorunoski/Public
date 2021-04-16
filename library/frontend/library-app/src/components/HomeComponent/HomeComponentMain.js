import React from "react";
import NavbarComponent from "../NavbarComponent/NavbarComponent";
import BookList from "./BookList";
import AddBookComponent from "./AddBookComponent";

class HomeComponentMain extends React.Component{
    state={
        render_add_book:false
    }
    unmountAdd = () =>{
        this.setState({render_add_book:false})
    }
    addBook=()=>{
        this.setState({render_add_book:true})
    }
    render() {
        return (
            <div>
                <NavbarComponent active="home"/>
                <BookList/>
                <div className="container mt-2">
                    {this.state.render_add_book?<AddBookComponent unmount={this.unmountAdd}/>:<button className="btn btn-outline-success" onClick={this.addBook}>Add Book</button>}
                </div>
            </div>
        );
    }
}
export default HomeComponentMain