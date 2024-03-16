package no.hvl.dat251.group_c.backend.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authorizationHeader = request.getHeader("Authorization");

        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        try {
            String token = authorizationHeader.replace("Bearer ", "");
            // Supabase uses RS256 ?
            // Verification logic goes here
            Algorithm algorithm = Algorithm.HMAC256("your-supabase-jwt-secret");
            DecodedJWT decodedJWT = JWT.require(algorithm).build().verify(token);
        } catch (Exception e) {
            // Sets the HTTP response status to 401 Unauthorized
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Error verifying JWT token");
            return;
        }

        filterChain.doFilter(request, response);
    }
}



