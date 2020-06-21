#ifndef MYWORK_SQUARE_HPP
#define MYWORK_SQUARE_HPP

#include <cmath>

#include "rectangle.hpp"

namespace mywork
{

class Square : public Rectangle
{
public:
    explicit Square(COLORS color_ = COLOR_BLACK, const Point& middle_ = Point(150, 150), double side_ = 20);
    virtual ~Square() = default;
private:
    double m_side;
    
    virtual void DrawImpl() const;
    virtual void WhoAmI() const;
    
    static const int POINTS = 4;
};

} // mywork

#endif /* MYWORK_SQUARE_HPP */
