import React from "react";
import axios from "axios";

class AddBookComponent extends React.Component{
    state={
        name:"",
        category:"",
        availableCopies: "",
        authorId:"",
        authors:[],
        loading:false
    }
    fetchAuthors(){
        this.setState({loading:true})
        fetch("http://localhost:3305/auth/all")
            .then(res=>res.json())
            .then(data=>{
                this.setState({authors:data})
                this.setState({loading:false})
            })
    }
    componentDidMount() {
        this.fetchAuthors()
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
        axios.post('http://localhost:3305/book/' + this.state.authorId, payload, {headers})
            .then(response => console.log("RESPONSE: " + response))
        this.props.unmount()
    }
    render() {
        let atrs = this.state.authors.map(a => <option value={a.id}>{a.name} {a.surname}</option>)
        return (
            <div className="border border-primary rounded p-3">
                <form className="m-2 mt-0" onSubmit={this.handleSubmit}>
                    <div className="form-group mb-3">
                        <label htmlFor="bknm" className="form-label">Book name: </label>
                        <input type="text"
                               className="form-control"
                               id="bknm"
                               placeholder="Enter book name"
                               name="name"
                               onChange={this.handleChange}
                        />
                    </div>
                    <div className="form-group mb-3">
                        <div className="form-group col-md-12">
                            <label htmlFor="categories" className="form-label">Category</label>
                            <select id="categories" className="form-control" name="category"
                                    onChange={this.handleChange}>
                                <option value="">Select book category</option>
                                <option value="NOVEL">NOVEL</option>
                                <option value="THRILLER">THRILLER</option>
                                <option value="HISTORY">HISTORY</option>
                                <option value="FANTASY">FANTASY</option>
                                <option value="BIOGRAPHY">BIOGRAPHY</option>
                                <option value="CLASSICS">CLASSICS</option>
                                <option value="DRAMA">DRAMA</option>
                            </select>
                        </div>
                    </div>
                    <div className="form-group mb-3">
                        <label htmlFor="ac" className="form-label">Available copies: </label>
                        <input type="number"
                               className="form-control"
                               id="ac"
                               name="availableCopies"
                               onChange={this.handleChange}
                        />
                    </div>
                    <div className="form-row mb-3">
                        <div className="form-group col-md-12">
                            <label htmlFor="authors" className="form-label">Authors</label>
                            <select id="authors" className="form-control" name="authorId"
                                    onChange={this.handleChange}>
                                <option value="">Select book author</option>
                                {atrs}
                            </select>
                        </div>
                    </div>
                    <div className="form-group">
                        <button className="btn btn-outline-success float-end">Add book</button>
                    </div>
                </form>
                <button className="btn btn-outline-danger mx-2" onClick={this.props.unmount}>Cancel</button>
            </div>
        );
    }
}
export default AddBookComponent