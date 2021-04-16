import React from "react";
class CategoryList extends React.Component{
    render() {
        return (
            <div className="container">
                <ul className="list-group">
                    <div className="list-group-item list-group-item-action rounded-pill border border-dark px-lg-5 px-md-4 px-sm-3">
                        <h4 className="text-justify text-center px-6">NOVEL</h4>
                    </div>
                    <div className="list-group-item list-group-item-action rounded-pill border border-dark px-lg-5 px-md-4 px-sm-3">
                        <h4 className="text-justify text-center px-6">THRILLER</h4>
                    </div>
                    <div className="list-group-item list-group-item-action rounded-pill border border-dark px-lg-5 px-md-4 px-sm-3">
                        <h4 className="text-justify text-center px-6">HISTORY</h4>
                    </div>
                    <div className="list-group-item list-group-item-action rounded-pill border border-dark px-lg-5 px-md-4 px-sm-3">
                        <h4 className="text-justify text-center px-6">FANTASY</h4>
                    </div>
                    <div className="list-group-item list-group-item-action rounded-pill border border-dark px-lg-5 px-md-4 px-sm-3">
                        <h4 className="text-justify text-center px-6">BIOGRAPHY</h4>
                    </div>
                    <div className="list-group-item list-group-item-action rounded-pill border border-dark px-lg-5 px-md-4 px-sm-3">
                        <h4 className="text-justify text-center px-6">CLASSICS</h4>
                    </div>
                    <div className="list-group-item list-group-item-action rounded-pill border border-dark px-lg-5 px-md-4 px-sm-3">
                        <h4 className="text-justify text-center px-6">DRAMA</h4>
                    </div>
                </ul>
            </div>
        );
    }
}
export default CategoryList