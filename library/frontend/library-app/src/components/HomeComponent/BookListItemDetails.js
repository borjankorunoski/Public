import React from "react";
import axios from "axios";
import EditBookForm from "./EditBookForm";
class BookListItemDetails extends React.Component{
    state={
        n:-1,
        render_edit:false
    }
    handleeditunmount(){
        this.setState({render_edit:false})
    }
    componentDidMount() {
        this.setState({n:this.props.book_details.availableCopies})
    }
    markastaken=()=>{
        fetch("http://localhost:3305/book/checkout/"+this.props.book_details.id)
            .then(res => res.json())
            .then(data => {
                this.setState({n:data})
            }
            )
    }
    editbook=()=>{
        this.setState({render_edit:!this.state.render_edit})
    }
    deletebook=()=>{
        axios.delete("http://localhost:3305/book/del/"+this.props.book_details.id)
            .then(res => res.data)
            .then(data => {console.log(data)
                this.props.unmountMe()
                alert("Book deleted. Please refresh your page.")
            })
    }
    //todo: add_buttons
    render() {
        return (
            <div className="card border-dark" style={{"border-radius":"25px"}}>
                <div className="card-header text-center" style={{"border-radius":"25px"}} onClick={this.props.unmountMe}>
                    <h3>{this.props.book_details.name}</h3>
                </div>
                <div className="card-body" style={{"border-radius":"25px"}}>
                    <p>
                        <b>Author: </b>{this.props.book_details.author.name + " " + this.props.book_details.author.surname} <br/>
                        <b>Category: </b>{this.props.book_details.category} <br/>
                        <b>Country: </b>{this.props.book_details.author.country.name + " (" + this.props.book_details.author.country.continent + ")"} <br/>
                        <b>Copies available: </b>{this.state.n}<br/>
                    </p>
                    <div className="btn-group float-end">
                        <button className="btn btn-outline-primary" onClick={this.markastaken}>Mark as taken</button>
                        <button className="btn btn-outline-success mx-3" onClick={this.editbook}>Edit</button>
                        <button className="btn btn-outline-danger" onClick={this.deletebook}>Delete</button>
                    </div>
                    {this.state.render_edit?<EditBookForm book_details={this.props.book_details} unmount={this.handleeditunmount}/>:<p></p>}
                </div>
            </div>
        );
    }
}
export default BookListItemDetails