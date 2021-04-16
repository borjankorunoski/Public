import React from "react";
import BookListItemDetails from "./BookListItemDetails";

class BookListItem extends React.Component{
    state={
        render_details:false
    }
    handleClick = () =>{
        this.setState({render_details:true})
    }
    handleUnmount=()=>{
        this.setState({render_details:false})
    }
    handleUpdate = () =>{
        this.setState({render_details:false})
        this.setState({render_details:true})
    }
    render() {
        return (
            <span>
                {this.state.render_details?
                    <BookListItemDetails book_details={this.props.data} unmountMe={this.handleUnmount}/>
                    :
                    <div className="list-group-item list-group-item-action rounded-pill border border-dark px-lg-5 px-md-4 px-sm-3" onClick={this.handleClick}>
                        <h4 className="text-justify text-center px-6">{this.props.data.name}</h4>
                    </div>
                }
            </span>
        );
    }
}
export default BookListItem