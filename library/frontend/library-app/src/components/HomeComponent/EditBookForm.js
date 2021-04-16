import React from "react";
import axios from "axios";

class EditBookForm extends React.Component{
    state={
        name:"",
        category:"",
        availableCopies:-1
    }
    componentDidMount() {
        this.setState({name:this.props.book_details.name})
        this.setState({category:this.props.book_details.category})
        this.setState({availableCopies:this.props.book_details.availableCopies})
    }
    handleChange = (event) => {
        const {name, value, checked, type} = event.target
        this.setState({[name]: value})
    }
    handleSubmit = () => {
        const payload = {
            "name": this.state.name,
            "category": this.state.category,
            "availableCopies":this.state.availableCopies
        }
        const headers = {
            "Content-Type": "application/json"
        }
        axios.patch('http://localhost:3305/book/edit/' + this.props.book_details.id, payload, {headers})
            .then(response => console.log("RESPONSE: " + response))
        this.props.unmount()
    }
    render() {
        return (
            <div className="border border-primary rounded p-2">
                <form onSubmit={this.handleSubmit}>
                    <div className="mb-3">
                        <label htmlFor="bookname" className="form-label">Book Title: </label>
                        <input type="text" className="form-control" id="bookname" name="name" value={this.state.name} onChange={this.handleChange}/>
                    </div>
                    <div className="mb-3">
                        <label htmlFor="bookcate" className="form-label">Category: </label>
                        <input type="text" className="form-control" id="bookcate" name="category" value={this.state.category} onChange={this.handleChange}/>
                    </div>
                    <div className="mb-3">
                        <label htmlFor="cpy" className="form-label">Available copies: </label>
                        <input type="text" className="form-control" id="cpy" name="availableCopies" value={this.state.availableCopies} onChange={this.handleChange}/>
                    </div>

                    <button type="submit" className="btn btn-primary">Submit</button>
                </form>
            </div>
        );
    }
}
export default EditBookForm